# SE333 Final Project — AI-Powered Testing Agent
**Student:** Yasin Mekki  
**Course:** SE333 Software Testing — DePaul University  
**Date:** March 2026

---

## Project Overview

This project builds an intelligent testing agent using the Model Context Protocol (MCP)
that automatically generates JUnit test cases for the Spring PetClinic application,
measures code coverage using JaCoCo, and iterates to improve coverage across multiple
generations.

**Technical Stack:**
- Java 17 / Spring Boot 4.0.3
- Maven 3.9.12
- JaCoCo 0.8.14 (coverage reporting)
- Python 3.11 / FastMCP 3.1.0 (MCP server)
- VS Code with GitHub Copilot (agent runtime)
- Git / GitHub (version control)

---

## MCP Tool API Documentation

The MCP server (`mcp-server/main.py`) exposes three tools:

### `run_maven_test`
Runs `mvn clean test` in the given project directory and returns the output.

**Input:**
- `project_path` (string): Absolute path to the Maven project

**Output:**
- Last 3000 characters of Maven output (string)

**Example:**
```
run_maven_test("C:/Users/Yasin/School/software testing/Final Project/spring-petclinic")
```

### `parse_jacoco`
Parses a JaCoCo XML coverage report and returns a list of uncovered methods.

**Input:**
- `xml_path` (string): Absolute path to `jacoco.xml`

**Output:**
- Newline-separated list of uncovered methods with missed/covered instruction counts

**Example:**
```
parse_jacoco("C:/Users/.../target/site/jacoco/jacoco.xml")
```

### `add`
Adds two numbers. Used to verify MCP server connectivity.

**Input:** `a` (int), `b` (int)  
**Output:** sum (int)

---

## Installation & Configuration Guide

### Prerequisites
- Java 17+
- Maven 3.6+
- Python 3.11+
- Node.js 18+
- VS Code with GitHub Copilot extension
- Git

### Step 1 — Clone the repository
```bash
git clone https://github.com/YMekki/final_project_se333.git
cd final_project_se333
```

### Step 2 — Set up the MCP server
```bash
cd mcp-server
uv venv
.venv\Scripts\activate       # Windows
uv add "mcp[cli]" httpx fastmcp
python main.py
```
Server will start at `http://127.0.0.1:8000/sse`

### Step 3 — Connect MCP server to VS Code
1. Press `Ctrl+Shift+P` → search `MCP: Add Server`
2. Select HTTP (SSE)
3. Enter URL: `http://127.0.0.1:8000/sse`
4. Name it: `se333-mcp-server`

### Step 4 — Run the testing agent
1. Open spring-petclinic folder in VS Code
2. Open Chat panel, set mode to Agent
3. Type `#file:.github/prompts/tester.prompt.md` and press Enter
4. Allow tool calls when prompted

### Step 5 — Run tests manually
```bash
cd spring-petclinic
.\mvnw clean test jacoco:report "-Dcheckstyle.skip=true"
start target\site\jacoco\index.html
```

---

## Troubleshooting & FAQ

**Q: Maven fails with checkstyle violation**  
A: Add `"-Dcheckstyle.skip=true"` to your mvnw command. The `.metals/` folder
from VS Code triggers a false positive.

**Q: MCP server not connecting to VS Code**  
A: Make sure `python main.py` is running in a separate terminal before connecting.
The server must be running first.

**Q: PowerShell says scripts are disabled**  
A: Run `Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy RemoteSigned`

**Q: Git says "dubious ownership"**  
A: Run `git config --global --add safe.directory 'C:/path/to/your/repo'`

**Q: Java formatting errors on test files**  
A: Run `.\mvnw spring-javaformat:apply` before running tests.

---

## Reflection Report

### Introduction
This project implements an AI-assisted software testing agent for the Spring PetClinic
application using the Model Context Protocol. The goal was to build a system that
automatically generates JUnit tests, measures code coverage using JaCoCo, and iterates
to improve coverage — all orchestrated through VS Code's GitHub Copilot agent mode
connected to a custom FastMCP server.

### Methodology
The approach followed a four-phase iterative process:

**Phase 1 — Environment Setup:** Configured the development environment including
Java, Maven, Python, Node.js, and VS Code. Built a FastMCP server exposing two core
tools: `run_maven_test` for executing the Maven test suite and `parse_jacoco` for
parsing JaCoCo XML coverage reports.

**Phase 2 — Baseline:** Cloned Spring PetClinic, removed all existing tests to
establish a zero-coverage baseline, and confirmed `mvn clean test` reported
"No tests to run."

**Phase 3 — Iterative Test Generation:** The agent was instructed via a prompt file
(`.github/prompts/tester.prompt.md`) to generate tests, run Maven, parse coverage,
identify gaps, and repeat. Each iteration targeted a different package.

**Phase 4 — Coverage Improvement:** Four iterations were executed, each adding test
classes targeting different packages (owner, vet, model).

### Results & Discussion

**Coverage Improvement:**

| Iteration | Tests | Coverage |
|-----------|-------|----------|
| Baseline  | 0     | 0%       |
| 1         | 3     | 12%      |
| 2         | 6     | 15%      |
| 3         | 14    | 19%      |
| 4         | 21    | 25%      |

**Analysis of Coverage Patterns:**
The model package responded fastest to unit testing, reaching 98% coverage quickly
because its classes are pure data objects with no framework dependencies. The owner
package proved harder to cover because many classes involve Spring MVC controllers
that require a full application context to test properly. The system package remained
at 0% as it requires integration-level testing with Spring Boot's test context.

**Insights from AI-Assisted Development:**
The MCP agent was effective at reading source files and generating syntactically
correct test stubs. However, it struggled with iterating autonomously — it required
manual intervention when stuck in loops and needed the checkstyle skip flag to be
added manually. The agent was most useful as a fast first-pass generator that produced
tests I then verified and understood before running.

**Recommendations for Future Enhancements:**
- Add a `run_maven_with_flags` tool that automatically includes `-Dcheckstyle.skip=true`
- Implement a coverage trend tracker that stores per-iteration metrics to JSON
- Add Spring Boot integration test support so controller classes can be covered
- Integrate GitHub MCP server for automated branch creation and PR workflows