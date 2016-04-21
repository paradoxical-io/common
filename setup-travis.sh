#!/usr/bin/env bash

read -p "SONATYPE_PASSWORD=" SONATYPE_PASSWORD
read -p "GPG_PASSWORD=" GPG_PASSWORD

travis encrypt "SONATYPE_PASSWORD=${SONATYPE_PASSWORD}" -a
travis encrypt "SONATYPE_PASSWORD=${SONATYPE_PASSWORD}" -a


travis encrypt-file gpg/paradoxical-io-private.gpg gpg/paradoxical-io-private.gpg.enc \
    -w gpg/paradoxical-io-private.gpg -p

read -p "GPG_PRIVATE_KEY_ENCRYPTION_KEY=" GPG_PRIVATE_KEY_ENCRYPTION_KEY
read -p "GPG_PRIVATE_KEY_ENCRYPTION_IV=" GPG_PRIVATE_KEY_ENCRYPTION_IV


travis encrypt "SONATYPE_PASSWORD=${SONATYPE_PASSWORD}" -a
travis encrypt "SONATYPE_PASSWORD=${SONATYPE_PASSWORD}" -a

echo "use \$GPG_PRIVATE_KEY_ENCRYPTION_KEY and \$GPG_PRIVATE_KEY_ENCRYPTION_IV instead"

