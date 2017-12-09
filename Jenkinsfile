node {
	stage ('Checkout') {
		checout scm
	}
	stage ('Build') {
		bat 'gradlew.bat clean build'
	}
}