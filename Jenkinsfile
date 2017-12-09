node {
	stage ('Checkout') {
		checkout scm
	}
	stage ('Build') {
		bat 'gradlew.bat clean build'
	}
	stage ('Test') {
		bat 'gradlew.bat test'
	}
}