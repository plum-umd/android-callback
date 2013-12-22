ant | sed -n '/\[javadoc\] android.*/p' | cut -c 13- > callback.txt
ant clean > /dev/null
