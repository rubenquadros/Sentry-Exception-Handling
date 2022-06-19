package com.ruben.exceptioncatcher.base

/**
 * Created by Ruben Quadros on 12/06/22
 **/
class CustomException (override val message: String = "This is my custom exception"): Exception(message)