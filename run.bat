taskkill /f /fi "WindowTitle eq demo-cicd" /t
title demo-cicd
call java -jar ./target/demo-cicd-0.0.1-SNAPSHOT.jar