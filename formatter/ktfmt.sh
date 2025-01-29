echo "Downloading formatter...."

# download formatter from facebook kotlin formatter repo
wget -q "https://github.com/facebook/ktfmt/releases/download/v0.53/ktfmt-0.53-jar-with-dependencies.jar" -O ktfmt.jar 2>/dev/null

# find all .kt files of ../ dir and subdirs
find ../ -name "*.kt" -exec java -jar ktfmt.jar --google-style {} +

# delete after use
rm -rf ktfmt.jar