set projectLocation=C:\Users\Admin\eclipse-workspace\CodingTest

cd %projectLocation%

set classpath=%projectLocation%\bin;%projectLocation%\lib\*;C:\Users\Admin\Desktop\*

java org.testng.TestNG %projectLocation%\AutomationTestSuite.xml

pause