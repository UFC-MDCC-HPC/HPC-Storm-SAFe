package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.util.FileUtil;
import br.ufc.mdcc.pargo.safe.util.SAFeConstants;

public class FileUtilTest {

	public static void main(String[] args) {
		
		String res = FileUtil.readFileAsString(SAFeConstants.ARCH_FILE_TEST);
		System.out.println(res);
	}
}
