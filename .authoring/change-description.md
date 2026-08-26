**Rename the learning-objectives file and its root key.** `.case/competencies.yaml` is now `.case/learning_objectives.yaml`, and its root key reads `learning_objectives:` rather than `competencies:`. The file has always described what the case teaches; in Fito a *competence* is a different thing — a tracked skill on a learner's profile, not something a case declares.

This version also carries the **prerequisite descriptions** through to the case page for the first time. The text was already written in `.case/prerequisites.yaml`, but the publish pipeline dropped it, so a learner could not read what each prerequisite meant.

Same-reference perfection — the knowledge references, Bloom levels, rubric and solution are untouched.
