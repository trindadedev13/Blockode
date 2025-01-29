echo "Downloading formatter...."

# download formatter from google java formatter repo
wget -q "https://github.com/google/google-java-format/releases/download/v1.24.0/google-java-format-1.24.0-all-deps.jar" -O "google-java-format.jar" 2>/dev/null

# find all .java files of ../ dir and subdirs
find ../ -name "*.java" -exec java -jar google-java-format.jar --replace {} +

# delete after use
rm -rf google-java-format.jar