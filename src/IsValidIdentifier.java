public class IsValidIdentifier{
  /**
   * Check whether the given String is a valid identifier according
   * to the Java Language specifications.
   *
   * See The Java Language Specification Second Edition, Section 3.8
   * for the definition of what is a valid identifier.
   *
   * @param s String to check
   *
   * @return <code>true</code> if the given String is a valid Java
   *         identifier, <code>false</code> otherwise.
   */
  public final static boolean isValidJavaIdentifier(String s)
  {
     // an empty or null string cannot be a valid identifier
     if (s == null || s.length() == 0 || s.isEmpty())
     {
        return false;
     }

     char[] c = s.toCharArray();
     if (!Character.isJavaIdentifierStart(c[0]))
     {
        return false;
     }

     for (int i = 1; i < c.length; i++)
     {
        if (!Character.isJavaIdentifierPart(c[i]))
        {
           return false;
        }
     }

     return true;
  }



}