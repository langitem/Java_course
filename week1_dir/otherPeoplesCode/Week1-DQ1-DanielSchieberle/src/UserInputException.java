// UserInputException.java
// Exception handling for user input
// Author: Daniel Schieberle
// Last Update: July 7th 2013

// UserInputException class declaration extending Throwable
class UserInputException extends Throwable
{
	  // storage for error message
	  String message;
	
      //Constructor without parameter
      public UserInputException() {
    	  super();
    	  this.message = "Unknown";
      }

      //Constructor accepting message string as parameter
      public UserInputException(String message) {
         super(message);
         this.message = message;
      }
      
      // Getter for error-message
      public String getErrorMessage() {
    	  return this.message;
      }
      
 } // end class UserInputException