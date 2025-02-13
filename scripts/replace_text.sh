#!/bin/bash

DIRECTORY="../" # use ../ because the script is inside the shellscript folder

# Text to be replaced
OLD_TEXT="dev.trindadedev.blockode.ui.components.editor"
NEW_TEXT="dev.trindadedev.blockode.ui.components.editor"

find "$DIRECTORY" -name "shellscript" -o -name ".git" -prune -o -type f -print | while read -r file; do
    sed -i "s/$OLD_TEXT/$NEW_TEXT/g" "$file"
    echo "Text replaced in: $file"
done

echo "Replacement completed!"