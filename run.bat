taskkill /f /fi "WindowTitle eq demo-cicd" /t
title demo-cicd
call mvn spring-boot:run