package ru.nsu.ci;

import ru.nsu.ci.translator.ParseException;
import ru.nsu.ci.translator.TokenMgrError;

public class NumStorError extends Error{
	
	NumStorError(String error){
		super(error);
	}
}