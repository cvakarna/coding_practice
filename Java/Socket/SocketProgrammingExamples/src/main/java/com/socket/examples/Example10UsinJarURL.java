package com.socket.examples;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map.Entry;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.apache.log4j.Logger;

public class Example10UsinJarURL {

	public static Logger log = Logger.getLogger(Example10UsinJarURL.class);

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Example10UsinJarURL ex = new Example10UsinJarURL();
		ex.createSocketObject();
	}

	private void createSocketObject() throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {	
	  String JAR_URL = "jar:file:/media/jothipandiyan/Bizruntime/bean.jar!/";
	  String JAR_FILE_PATH ="file://home/jothipandiyan/Desktop/bean.jar";
	  
	  URL FileSysUrl = new URL(JAR_URL);
	  JarURLConnection jarURLConnection =  (JarURLConnection)FileSysUrl.openConnection();
      
	  JarFile jarFile = jarURLConnection.getJarFile();
      log.debug("Jar Name: " + jarFile.getName());
      log.debug("\nJar Entry: " + jarURLConnection.getJarEntry());
      Manifest manifest = jarFile.getManifest();
      for (Entry entry : manifest.getMainAttributes().entrySet()) 
    	  log.debug(entry.getKey() +": "+ entry.getValue());
    	  
     
      URL[] classLoaderUrls = new URL[]{new URL(JAR_FILE_PATH)};
      URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);
      String mainClassName = manifest.getMainAttributes().getValue(Attributes.Name.MAIN_CLASS); 
      Class beanClass = urlClassLoader.loadClass(mainClassName);
      Method method = beanClass.getMethod("main", String[].class);
      String[] params = null;
      method.invoke(null, (Object) params);

      

	
	}
}
