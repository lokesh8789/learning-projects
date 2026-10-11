export const ERROR_CODE_MESSAGES: Record<string, string> = {
  invalid_provider_response:
    'Invalid response received from GitHub. Please try signing in again.',
  email_not_provided:
    'Your GitHub account does not have a public verified email address. Please make your email public in GitHub settings or sign up with email.',
  unsupported_provider:
    'This login provider is currently unsupported. Please sign in with email.',
  user_not_found:
    'No account found with this email. Please create an account first.',
  user_already_exists:
    'An account with this email already exists. Please log in instead.',
  invalid_credentials:
    'Invalid email or password. Please verify your credentials and try again.',
  authentication_failed:
    'Authentication failed. Please verify your credentials and try again.',
  internal_server_error:
    'An internal server error occurred while processing authentication. Please try again later.',
  access_denied:
    'GitHub sign-in was cancelled by the user.',
};

/**
 * Maps a backend error code to a user-friendly message.
 */
export function formatErrorCode(errorCode: string): string {
  if (!errorCode) return 'An unexpected error occurred. Please try again.';
  const normalized = errorCode.toLowerCase().trim();
  return ERROR_CODE_MESSAGES[normalized] || errorCode.replace(/_/g, ' ');
}

/**
 * Extracts a human-readable error message from an HTTP error, OAuth error string, or unknown exception.
 */
export function extractErrorMessage(
  error: unknown,
  fallbackMessage: string = 'Operation failed. Please try again.'
): string {
  if (!error) return fallbackMessage;

  // Direct string error (e.g. from OAuth query param: ?error=email_not_provided)
  if (typeof error === 'string') {
    return formatErrorCode(error);
  }

  return fallbackMessage;
}
