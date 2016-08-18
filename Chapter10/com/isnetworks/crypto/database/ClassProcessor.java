package com.isnetworks.RMIifier;

/**
  * Super generic interface so that other class processing classes can use the same RMIifier
	* main() method.  Pretty much a waste, at least at this point.
	*/

public interface ClassProcessor {
	public void process( Class cl );
}