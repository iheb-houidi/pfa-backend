
pipeline {
  agent any
  tools {
      maven 'maven'
     jdk 'Java17'
      }
      stages{
        stage('init'){
            steps{
                script {
                   echo "connected to github successfully"
                }
            }
        }

         stage('build jar'){
            steps{
                script{
                  echo "building the application..."
                  sh 'mvn package'
                }

            }
         }

         stage('build image'){
            'steps'{
                script{
                    echo "building image"
                      withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                      sh 'docker build -t ihebdockerid/app_backend:2.0 .'
                      sh 'echo $PASS | docker login -u $USER --password-stdin'
                      sh 'docker push ihebdockerid/app_backend:2.0' }
            }
        }
         }
         
           stage('deploy'){
              steps{
                script{
                    echo "deploying the application..."
                }
            }
         }

      }
  }

