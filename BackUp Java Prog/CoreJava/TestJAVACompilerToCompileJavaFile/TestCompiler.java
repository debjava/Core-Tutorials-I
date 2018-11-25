import com.sun.tools.javac.Main;

public class TestCompiler 
{
	public static int compile(String fileName, String sourceDir, String destDir)
	{
		int metdExcSts = -1;

		// Prepare the file name with its source directory
		String filetocompile = sourceDir + fileName + ".java";

		
		
		// Pass the arguments to the compiler by specifying to put the
		// compiled file in the targetDir
		String[] args = new String[] { "-d", destDir, filetocompile};

		// Compile the java file by passing the arguments
		// Returns the compilation status
		metdExcSts = Main.compile(args);
		
		System.out.println(" Value of metdExcSts ::: "+metdExcSts);
		return metdExcSts;
	}
	
	public static void main(String[] args) 
	{
		int com = new TestCompiler().compile("Test","D:/JavaTempTest/TestCompiler/","D:/JavaTempTest/TestCompiler/");
		System.out.println(" Value of int ::: "+com);
	}

}
