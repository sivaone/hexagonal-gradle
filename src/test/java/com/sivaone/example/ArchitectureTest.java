package com.sivaone.example;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = ArchitectureTest.BASE_PACKAGE)
public class ArchitectureTest {
  public static final String BASE_PACKAGE = "com.sivaone.example";

  @ArchTest
  public static final ArchRule rule1 = Architectures.onionArchitecture()
      .domainModels(BASE_PACKAGE + ".domain..")
      .domainServices(BASE_PACKAGE + ".domain..")
      .applicationServices(BASE_PACKAGE + ".usecase..")
      .adapter("persistence", BASE_PACKAGE + ".persistence..")
      .adapter("api", BASE_PACKAGE + ".api..");

}
