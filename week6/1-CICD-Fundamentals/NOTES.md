# Module 6.1: CI/CD Fundamentals

## Vocabulary and Concepts

- **Continuous Integration (CI):** Every push/PR automatically triggers an automated build and test run, catching integration problems early instead of at release time.
- **Continuous Delivery/Deployment (CD):** Once CI passes, the pipeline automatically packages the app and makes it available (a release artifact, a Pages deployment, etc.). "Delivery" stops one manual click before production, while "Deployment" goes all the way. This guide implements Delivery only.
- **Workflow / pipeline file:** A YAML file describing what to run and when (e.g., `.github/workflows/*.yml` for GitHub Actions, `.gitlab-ci.yml` for GitLab CI).
- **Triggers:** Events that start a workflow, such as `push`, `pull_request`, `workflow_dispatch` (manual button), `schedule` (cron), or tag pushes (e.g., `on: push: tags: ['v*']`).
- **Runner/agent:** The machine (usually ephemeral, cloud-hosted) that executes the job. `ubuntu-latest` is the default for both GitHub and GitLab platforms.
- **Jobs & steps:** A workflow has one or more **jobs** (which can run in parallel or be chained with `needs:`). Each job has ordered **steps** (e.g., checkout code, set up a language runtime, run a command, upload an artifact).
- **Caching:** Speeds up repeat runs by persisting dependencies (like `~/.m2` for Maven or `node_modules` for npm) between runs, keyed by the lockfile hash.
- **Artifacts:** Files produced by a job (e.g., test reports, coverage reports, built `.jar` or `dist/` folder) that can be downloaded from the run or passed to a later job.
- **Matrix builds:** Run the same job definition once per value in a list (e.g., once per microservice, or once per Node/Java version) instead of duplicating the job.
- **Secrets:** Encrypted values (API tokens, credentials) injected as environment variables at run time. They are configured in the repo's Settings → Secrets and never committed to the repo.
- **Branch protection / required status checks:** A repository setting that blocks merging a PR into a protected branch (e.g., `main`) until the named CI workflow reports success.
