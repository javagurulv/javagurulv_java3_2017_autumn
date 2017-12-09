node {
	stage ('Checkout') {
		checkout scm
	}
	stage ('Build') {
		bat 'gradlew.bat clean build snapshot'
	}
	stage ('Test') {
		bat 'gradlew.bat test'
	}
	stage ('Publish') {
		bat 'gradlew.bat snapshot publish'
	}
	stage ('Release') {
		bat 'gradlew.bat final'
	}
}