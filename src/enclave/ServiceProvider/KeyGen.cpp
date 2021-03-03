#include "ServiceProvider.h"

int main(int argc, char **argv) {
  if (argc < 2) {
    printf("Usage: ./keygen <public_key_cpp_file>\n");
    return 1;
  }

  const char *private_key_path = std::getenv("PRIVATE_KEY_PATH");
  if (!private_key_path) {
    printf("Set $PRIVATE_KEY_PATH to the file generated by openssl ecparam "
           "-genkey, probably "
           "called ${OPAQUE_HOME}/private_key.pem.");
    return 1;
  }
  service_provider.load_private_key(private_key_path);
  service_provider.export_public_key_code(argv[1]);

  return 0;
}
