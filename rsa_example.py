import rsa

publicKey, privateKey = rsa.newkeys(512)

msg = "attack is today".encode()

encryptedMessage = rsa.encrypt(msg,publicKey)
print("Encrypted message is : ", encryptedMessage)

decryptedMessage = rsa.decrypt(encryptedMessage,privateKey)
print("Decrypted message is : ", decryptedMessage)
