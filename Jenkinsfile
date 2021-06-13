pipeline {
    agent any
    stages {
        stage("Checkout") {
            steps {
                checkout(
                        [
                                $class           : 'GitSCM',
                                branches         : [[name: '*/main']],
                                browser          : [
                                        $class : 'GithubWeb',
                                        repoUrl: 'https://github.com/sivaone/hexagonal-gradle'
                                ],
                                extensions       : [[$class: 'CleanBeforeCheckout']],
                                userRemoteConfigs: [
                                        [
                                                credentialsId: 'GH_SIVAONE',
                                                url          : 'https://github.com/sivaone/hexagonal-gradle.git',
                                                name         : 'origin',
                                                refspec      : '+refs/heads/main:refs/remotes/origin/main'
                                        ]
                                ]
                        ]
                )
            }
        }

        stage("Build") {
            steps {
                withGradle {
                    bat 'gradlew.bat build -x test'
                }
            }
        }

        stage("Unit Test") {
            steps {
                withGradle {
                    bat 'gradlew.bat test'
                }
            }
        }

        stage("Sonar Scan") {
            environment {
                SCANNER_HOME = tool 'SonarQubeScanner'
            }
            steps {
                withSonarQubeEnv('SonarCloudOne') {
                    bat '%SCANNER_HOME%/bin/sonar-scanner.bat'
                }
            }
        }
    }
}