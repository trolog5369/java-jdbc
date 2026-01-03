# Java Exception Handling — Notes

Exception: An exception is an entity which interrupt the flow of the program  
and generates err results

eg: 10/2=5 is true if the program output is 2,3 other than 5 it's exception

Exception are further divided into 2 types  
1.Checked Exceptions: Exception which are checked at compile-time  
2.Unchecked Exception : Exception which are not checked at compile-time but at run-time

---

## Exception Handling in Java FlowChart

# Java Exception Handling — Notes

Exception: An exception is an entity which interrupt the flow of the program  
and generates err results

eg: 10/2=5 is true if the program output is 2,3 other than 5 it's exception

Exception are further divided into 2 types  
1.Checked Exceptions: Exception which are checked at compile-time  
2.Unchecked Exception : Exception which are not checked at compile-time but at run-time

---

## Exception Handling in Java FlowChart

                   Throwable (Superclass)
        (Program runs)                     (Program do not run)
             Exception                           Error
          IO Exception                     StackOverFlowError
          SQL Exception                    VirtualMachineError
          ClassNotFound Exception          OutOfMemoryError
          Runtime Exception (Run-time exception)
                   |
                   |
                   -> Arithmetic Exception
                      Null point Exception
                      NumberOfFormatException
                      IndexOutOfBound Exception
                               |
                               |
                               -> ArrayOutOfBound Exception
                                  StringindexOutOfBound Exception


---

## 5 keywords for Exception handling

Try  
Catch  
Finally  
Throw  
Throws

For every try block there's catch/finally block

---

## Try
- Any dangerous code we will put it in a try block
- It must be followed by a catch or finally block

## Catch
- If there's an exception in try then catch gets executed
- It must be preceded by try block which means we can't use catch block alone
- It can be followed by finally block later

## Finally
- Used to execute the necessary code of program
- It is executed whether the exception is handled or not

## Throw
- Used to throw an exception

## Throws
- Used to declare exceptions
- Specifies that there may occur an exception in method
- It doesn't throw an exception
- Always used with method signature

---

### IMP
It's a good practice if write the subclass class exception first instead of superclass  
INSTEAD of Superclass first then Subclass
