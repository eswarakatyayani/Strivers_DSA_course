//String → Integer
String s = "123";
int num = Integer.parseInt(s);

//String → Double
String s = "123.45";
double d = Double.parseDouble(s);

//String → Boolean
String s = "true";
boolean b = Boolean.parseBoolean(s);

//String → Character
String s = "A";
char c = s.charAt(0);

//String -> char[]
String s = "Hello";
char[] chars = s.toCharArray();

//String → Array of Strings (Split)
String s = "apple,banana,orange";
String[] arr = s.split(",");

//String → List
import java.util.Arrays;
import java.util.List;
String s = "apple,banana,orange";
List<String> list = Arrays.asList(s.split(","));

//Array → String (Joining elements)
String[] arr = {"apple", "banana", "orange"};
String s = String.join(",", arr);
