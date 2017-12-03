package com.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.threadlocal.Example;

public class GetFiles {
	private Logger log = Logger.getLogger(GetFiles.class);

	public static void main(String[] args) {
		GetFiles example = new GetFiles();
		example.demo();
	}

	private void demo() {
		File file = new File("/");
		// log.debug("File directory --> " + file.createNewFile());

		log.debug(Arrays.asList(File.listRoots()));

		for (File f1 : file.listFiles()) {
			log.debug(f1);
		}
		FileFilter filter = file1 -> {
			for (File f1 : file.listFiles()) {
				log.debug(f1);
			}
			return true;
		};
	

		filter.accept(file);
		
		File[] list = file.listFiles(filter);
		for (File f : list) {
			if (f.isFile()) {
			System.out.println(f.getPath() + " (File)");
			}
			else if (f.isDirectory()) {
			System.out.println(f.getPath() + " (Directory)");
			}
			}
	}
}