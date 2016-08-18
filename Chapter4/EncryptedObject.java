import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 *	EncryptedObject
 *
 *	This class is a reimplementation of javax.crypto.SealedObject.
 *
 *	It exists to enable sealing custom objects that are not
 *	located in the trusted classes directory (lib/ext).
 *
 */
public class EncryptedObject implements Serializable
{
  /**
   *	Byte array for the encrypted version of the
   *	serialized object
   */
  private byte[] mEncryptedObject;

  /**
   *	Byte array for the encoded parameters to
   *	the algorithm being used for encryption
   */
  private byte[] mEncodedParameters;

  /**
   *	The algorithm being used for encryption
   */
  private String mEncryptionAlgorithm;

  /**
   *	The name of the parameter algorithm
   */
  private String mParameterAlgorithm;

  /**
   *	Constructs an EncryptedObject from a serializable
   *	object with a given cipher.
   */
  public EncryptedObject (Serializable object, Cipher cipher)
  throws IOException, IllegalBlockSizeException
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(object);
    oos.flush();
    try
    {
      mEncryptedObject = cipher.doFinal(baos.toByteArray());
    } catch (BadPaddingException bpe) {
      throw new IllegalBlockSizeException(bpe.toString());
    }

    mEncryptionAlgorithm = cipher.getAlgorithm();
    AlgorithmParameters parameters = cipher.getParameters();

    if (parameters != null)
    {
      mEncodedParameters = parameters.getEncoded();
      mParameterAlgorithm = parameters.getAlgorithm();
    }
    oos.close();
  }

  /**
   *	Returns the algorithm used to encrypt the object
   */
  public final String getAlgorithm()
  {
    return mEncryptionAlgorithm;
  }

  /**
   *	Returns the object decrypted with the given cipher
   */
  public final Object getObject(Cipher cipher)
  throws IOException, ClassNotFoundException,
  IllegalBlockSizeException, BadPaddingException
  {
    ByteArrayInputStream bais =
    new ByteArrayInputStream(cipher.doFinal(mEncryptedObject));
    ObjectInputStream ois = new ObjectInputStream(bais);
    return ois.readObject();
  }

  /**
   *	Returns the object decrypted with the given key
   */
  public final Object getObject(Key key)
  throws IOException, ClassNotFoundException,
  NoSuchAlgorithmException, InvalidKeyException
  {
    AlgorithmParameters parameters = null;
    Cipher cipher;
    Object object;

    if (mEncodedParameters != null)
    {
      parameters = AlgorithmParameters.getInstance(mParameterAlgorithm);
      parameters.init(mEncodedParameters);
    }
    try
    {
      cipher = Cipher.getInstance(mEncryptionAlgorithm);
      cipher.init(Cipher.DECRYPT_MODE, key, parameters);
      object = getObject(cipher);
    } catch (NoSuchPaddingException nspe) {
      throw new NoSuchAlgorithmException(nspe.toString());
    } catch (InvalidAlgorithmParameterException iape) {
      throw new IOException(iape.toString());
    } catch (BadPaddingException bpe) {
      throw new IOException(bpe.toString());
    } catch (IllegalBlockSizeException ibe) {
      throw new IOException(ibe.toString());
    }
    return object;
  }

  /**
   *	Returns the object decrypted with the given
   *	key, using the provider requested
   */
  public final Object getObject(Key key, String provider)
  throws IOException, ClassNotFoundException,
  NoSuchAlgorithmException, NoSuchProviderException,
  InvalidKeyException
  {
    AlgorithmParameters parameters = null;
    Cipher cipher;
    Object object;

    if (mEncodedParameters != null)
    {
      parameters = AlgorithmParameters.getInstance(mParameterAlgorithm, provider);
      parameters.init(mEncodedParameters);
    }
    try
    {
      cipher = Cipher.getInstance(mEncryptionAlgorithm, provider);
      cipher.init(Cipher.DECRYPT_MODE, key, parameters);
      object = getObject(cipher);
    } catch (NoSuchPaddingException nspe) {
      throw new NoSuchAlgorithmException(nspe.toString());
    } catch (InvalidAlgorithmParameterException iape) {
      throw new IOException(iape.toString());
    } catch (BadPaddingException bpe) {
      throw new IOException(bpe.toString());
    } catch (IllegalBlockSizeException ibe) {
      throw new IOException(ibe.toString());
    }
    return object;
  }
}
