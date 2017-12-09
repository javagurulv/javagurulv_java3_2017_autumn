@"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"

choco install nssm -y

md c:\Software\JavaGuru
xcopy /y ..\core-app\build\libs\*.jar c:\Software\JavaGuru\core-app.jar

nssm install JavaGuru javaw.exe 
nssm set JavaGuru AppDirectory c:\Software\JavaGuru
nssm set JavaGuru AppParameters -jar core-app.jar