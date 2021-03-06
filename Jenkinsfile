pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK11_Centos' //Verisión preinstalada en la Configuración del Master
    gradle 'Gradle5.0_Centos'
  }
/*	Versiones disponibles
      JDK8_Mac
      JDK6_Centos
      JDK7_Centos
      JDK8_Centos
      JDK10_Centos
      JDK11_Centos
      JDK13_Centos
      JDK14_Centos
*/

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
	checkout([
		$class: 'GitSCM', 
		branches: [[name: '*/main']], 
		doGenerateSubmoduleConfigurations: false, 
		extensions: [], 
		gitTool: 'Default', 
		submoduleCfg: [], 
		userRemoteConfigs: [[
		credentialsId: 'GitHub_carolina0200', 
		url:'https://github.com/carolina0200/travel-packages'
		]]
	])

      }
    }

    stage('Compile & Unit Tests') {
      steps{
	dir("travel-packages") {
	  echo "------------>Compile & Unit Tests<------------"
    	  sh 'gradle clean'
	  sh 'gradle test'
	}
       
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
      steps {
        dir("travel-packages") {
           sh 'gradle build -x test'
        }
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'travel-packages/infraestructura/build/test-results/test/*.xml'
      junit 'travel-packages/dominio/build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'carolina.giraldo@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
