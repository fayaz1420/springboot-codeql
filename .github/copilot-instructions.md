# Copilot Custom Instructions

- When performing a code review, focus on identifying security vulnerabilities and suggest secure coding practices.
- Ensure that the code adheres to the repository's coding standards and best practices.
- Pay special attention to the use of external libraries and frameworks, ensuring they are up-to-date and used securely.
- Highlight any potential performance bottlenecks or areas for optimization.
- Provide feedback on code readability and maintainability, suggesting improvements where necessary.
- When reviewing code in the `src/main/java/com/springboot/springbootCodeql/service/` directory, prioritize identifying and mitigating security vulnerabilities such as SQL injection, command injection, path traversal, and SSRF.

---

# Path-Specific Instructions

## For `src/main/java/com/springboot/springbootCodeql/service/EmployeeService.java`
- Focus on ensuring that all methods are secure and free from vulnerabilities.
- Suggest secure alternatives for any commented-out vulnerable code.
- Verify that all database queries are parameterized to prevent SQL injection.
- Ensure that any user input is properly sanitized and validated.
- Recommend the use of secure APIs and libraries for file handling and network requests.

## For Test Code Review
- When reviewing test code, ensure that all test cases are comprehensive and cover edge cases.
- Verify that the tests follow the Arrange-Act-Assert (AAA) pattern for clarity and maintainability.
- Ensure that mock objects and dependencies are used appropriately to isolate the unit under test.
- Check that the test names are descriptive and clearly indicate the purpose of the test.
- Highlight any redundant or duplicate test cases and suggest their removal.
- Ensure that the tests do not rely on external systems or data, and recommend the use of in-memory databases or mocks where applicable.
- Verify that the tests are written to be deterministic and do not produce flaky results.
- Suggest improvements to test performance, especially for integration tests, to reduce execution time.