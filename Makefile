# Sample Makefile for the WACC Compiler lab: edit this to build your own comiler
# Locations

ANTLR_DIR	:= antlr_config
SOURCE_DIR	:= src/main/java/antlr
OUTPUT_DIR	:= bin 

# Tools

ANTLR	:= antlrBuild
FIND	:= find
RM	:= rm -rf
MKDIR	:= mkdir -p
JAVA	:= java
JAVAC	:= javac

JFLAGS	:= -sourcepath $(SOURCE_DIR) -d $(OUTPUT_DIR) -cp lib/antlr-4.7-complete.jar 

# the make rules

all: rules compile

# runs the antlr build script then attempts to compile all .java files within src
rules:
	cd $(ANTLR_DIR) && ./$(ANTLR)
	$(FIND) $(SOURCE_DIR) -name '*.java' > $@
	$(MKDIR) $(OUTPUT_DIR)
	$(JAVAC) $(JFLAGS) @$@
	$(RM) rules
	./gradlew build -x test

compile:
	./gradlew build -x test

clean:
	$(RM) rules $(OUTPUT_DIR)
	./gradlew clean

.PHONY: all rules clean test


