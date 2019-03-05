#!/usr/bin/env groovy

node('zen') {

    withEnv(["GRADLE_OPTS=-Xmx1024m"]) {

        def gradle = "./gradlew"

        try{

            checkout scm
            stage("Clean") {
                echo "Cleaning...."
                sh "${gradle} clean"
            }
            stage("Build") {
                echo "Building...."
                sh "${gradle} build -x test"
            }
            stage("Test") {
                echo "Testing...."
                sh "${gradle} test"
                step([$class: "JUnitResultArchiver", testResults: "**/build/test-results/test/TEST-*.xml"])
            }
            stage("Deploy") {
                if (currentBuild.result == null || currentBuild.result == "SUCCESS") { 1
                    echo "Deploy...."
                    echo "Running ${env.BUILD_ID} for job ${env.JOB_NAME} on ${env.JENKINS_URL}"
                }
            }

        }catch (Exception e) {

               try {
                    //Caso tenha falhado no teste armazena o relatorio de teste.
                    step([$class: "JUnitResultArchiver", testResults: "**/build/test-results/test/TEST-*.xml"])
               } catch (Exception ex) {
                        throw ex
               }

               throw e
        }

    }
}