node {
	stage ('Checkout') {
		checkout scm
	}
	stage ('Build') {
		bat 'gradlew.bat clean build'
	}
	stage ('Build') {
		bat 'gradlew.bat test'
	}
}