
# process.awk

# BEGIN block runs before processing the file
BEGIN {
    FS = "|"         # Set the input field separator to "|"
    OFS = ","        # Set the output field separator to ","
    print "Processing Start..."
}

# Pattern-action to process lines with "Aggarwal" (case-insensitive)
tolower($0) ~ /aggarwal/ {
    print $1, $2, $3  # Print the first three fields
}

# END block runs after processing the file
END {
    print "Processing Complete."
}
