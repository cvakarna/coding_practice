package com.chapter1;


@Description(name=@Name(first="John", last="Jacobs"),
version=@Version(major=1, minor=2),comments="Just a test class")
public class AnnotationType {


}



 @interface Description {
Name name();
Version version();
String comments() default "";
}
