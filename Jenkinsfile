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
    }
}