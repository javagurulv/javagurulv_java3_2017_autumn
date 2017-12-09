C:\ProgramData\chocolatey\bin\nssm.exe stop JavaGuru 

xcopy /y ..\core-app\build\libs\*.jar c:\Software\JavaGuru\core-app.jar

C:\ProgramData\chocolatey\bin\nssm.exe start JavaGuru