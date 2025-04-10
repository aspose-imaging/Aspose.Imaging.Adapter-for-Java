# Aspose.Imaging.HEIC.Adapter for Java

![Openize.HEIC](publish/aspose_adapter_java_heic.svg)

**Aspose.Imaging.HEIC.Adapter for Java** is an extension for [Aspose.Imaging for Java](https://products.aspose.com/imaging/java/) providing support of [Openize.HEIC](https://github.com/openize-com/openize-heic-java/), this allows you to use the functions of both libraries as a single whole and expand export between formats. This adapter supports exporting HEIC to formats Png, Tiff, Pdf, Svg, Jpeg, Gif, Bmp, Emf, Wmf, J2k, Webp, [etc...](https://docs.aspose.com/imaging/java/supported-file-formats/)

## Platform Dependence

Aspose.Imaging.HEIC.Adapter for Java can be used to develop applications on Windows, Linux, macOS. The supported platforms include Java >= 1.8.

## License
The MIT License (MIT)
More details here [LICENSE.txt](publish/LICENSE.txt)

## Getting Started

Are you ready to give Aspose.Imaging.HEIC.Adapter for Java a try? 

### **Installing from Maven Repository**
Aspose hosts all Java APIs on [Maven repository](https://releases.aspose.com/java/repo/).

**Specify Maven Repository Configuration**
First you need to specify Aspose Maven Repository configuration / location in your Maven pom.xml as follows:

``` xml

 <repositories>
    <repository>
        <id>AsposeJavaRepo</id>
        <name>Aspose Java Repository</name>
        <url>https://releases.aspose.com/java/repo/</url>
    </repository>
</repositories>

```

**Define Aspose.Imaging for Java API Dependency**

Then define Aspose.Imaging for Java API dependency in your pom.xml as follows:

``` xml

 <dependencies>
    <dependency>
        <groupId>com.aspose</groupId>
        <artifactId>aspose-imaging</artifactId>
        <version>25.4</version>
   </dependency>
   <!-- Actually the following artifact is Openize.Openize.Heic but built and signed by Aspose and placed in Aspose repo -->
    <dependency>
		<groupId>com.aspose</groupId>
		<artifactId>openize-heic</artifactId>
		<version>25.4</version>
	</dependency>
    <dependency>
        <groupId>com.aspose</groupId>
        <artifactId>aspose-imaging-heic-adapter</artifactId>
        <version>25.4</version>
	</dependency>

   <!-- if you need a documentation, please add the following dependency. For example it could be useful for IDE. -->
   <dependency>
        <groupId>com.aspose</groupId>
        <artifactId>aspose-imaging</artifactId>
        <version>25.4</version>
        <classifier>javadoc</classifier>
   </dependency>
    <dependency>
        <groupId>com.aspose</groupId>
        <artifactId>aspose-imaging-heic-adapter</artifactId>
        <version>25.4</version>
        <classifier>javadoc</classifier>
   </dependency>
</dependencies>

```

After performing above steps, Aspose.Imaging for Java dependency will finally be defined in your Maven Project.
Get more information here: 
[Java Image Processing Library or API can be installed through Maven.](https://docs.aspose.com/imaging/java/installation/)

 
## Product dependencies
This product is dependent on :
- [Aspose.Imaging Java is distributed under Aspose EULA license](https://www.conholdate.app/viewer/view/my6hZebP2Hvz3brV/aspose_end-user-license-agreement_2023-11-20.pdf.pdf);
- [Openize.HEIC is distributed under Openize.HEIC license](https://github.com/openize-heic/Openize.HEIC-for-Java/blob/main/LICENSE);
- [Openize.IsoBmff that is distributed under MIT License](https://github.com/openize-heic/Openize.HEIC-for-Java/blob/main/Openize.IsoBmff/LICENSE).

## Usage example


### Export HEIC to Png

```java

import com.aspose.imaging.heic.adapter.*;
import com.aspose.imaging.imageoptions.*;

// You need this only once
HEICImage.register();
try (Image image = com.aspose.imaging.Image.load("example.heic"))
{
	image.save("result.png");
}
```

### Export HEIC to Jpg

```java
import com.aspose.imaging.heic.adapter.*;
import com.aspose.imaging.imageoptions.*;

// You need this only once
HEICImage.register();
try (Image image = com.aspose.imaging.Image.load("example.heic"))
{
	image.save("result.jpg", new JpegOptions());
}
```


### Export HEIC to Pdf

```java
import com.aspose.imaging.heic.adapter.*;
import com.aspose.imaging.imageoptions.*;

// You need this only once
HEICImage.register();
try (Image image = com.aspose.imaging.Image.load("example.heic"))
{
	image.save("result.pdf", new PdfOptions());
}
```


### Export HEIC to Tiff

```java
import com.aspose.imaging.heic.adapter.*;
import com.aspose.imaging.imageoptions.*;

// You need this only once
HEICImage.register();
try (Image image = com.aspose.imaging.Image.load("example.heic", HEICLoadOptions.create()))
{
	image.save("result.tiff", new TiffOptions(TiffExpectedFormat.TiffJpegRgb));
}
```

### Export HEIC to Svg

```java
import com.aspose.imaging.heic.adapter.*;
import com.aspose.imaging.imageoptions.*;

// You need this only once
HEICImage.register();
try (Image image = com.aspose.imaging.Image.load("example.heic", HEICLoadOptions.create()))
{
	image.save("result.svg", new SvgOptions());
}
```
