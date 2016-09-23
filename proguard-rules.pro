# RetroLambda
-dontwarn java.lang.invoke.*

# Butterknife rules
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#

-dontwarn org.htmlcleaner.HtmlCleanerForAnt
-dontwarn javax.xml.*
-dontwarn org.jdom.xpath.JaxenXPath*
-dontwarn nl.siegmann.epublib.utilities.StreamWriter*
-dontwarn org.jdom.**
-dontwarn org.rikai.dictionary.db.JdbcSqliteDatabase

-keep class net.nightwhistler.htmlspanner.** {*;}
-dontwarn net.nightwhistler.htmlspanner.**

-dontwarn android.support.**
-keep class org.htmlcleaner.** {*;}

-keep class org.zorgblub.** {*;}

-dontwarn java.awt.**, org.apache.crimson.**, oracle.xml.parser.**, org.apache.xerces.**
-dontnote android.support.**

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

-keepclassmembers enum * { *; }
##---------------End: proguard configuration for Gson  ----------