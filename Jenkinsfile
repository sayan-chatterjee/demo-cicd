node {
	stage 'Checkout'
	checkout scm
	
	stage 'Compile'
	bat 'mvn -e clean compile'
	
	stage 'Package'
	bat 'mvn -DskipTests=true clean package'

	stage 'Start Application'
	#bat 'java -jar ./target/demo-cicd-0.0.1-SNAPSHOT.jar'
	bat 'run.bat'
}