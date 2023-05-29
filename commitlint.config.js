/* global module */
module.exports = {
    extends: ["@commitlint/config-conventional"],
    rules: {
        "type-enum": [
            2,
            "always",
            ["feat", "fix", "chore", "docs", "style", "refactor", "test"],
        ],
        "scope-empty": [2, "never"],
        "scope-enum": [
            2,
            "always",
            [
                "aoo",
                "assgi",
                "crud",
                "dev-desktop",
                "dev-web",
                "pig",
                "poo",
                "qa",
                "sgbd",
                "core",
            ],
        ],
        "subject-empty": [2, "never"],
        "subject-full-stop": [2, "never", "."],
        "subject-case": [2, "never", ["upper-case"]],
    },
}
