--
-- The MIT License (MIT)
--
-- MSUSEL Quamoco Implementation
-- Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
-- Software Engineering Laboratory and Idaho State University, Informatics and
-- Computer Science, Empirical Software Engineering Laboratory
--
-- Permission is hereby granted, free of charge, to any person obtaining a copy
-- of this software and associated documentation files (the "Software"), to deal
-- in the Software without restriction, including without limitation the rights
-- to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
-- copies of the Software, and to permit persons to whom the Software is
-- furnished to do so, subject to the following conditions:
--
-- The above copyright notice and this permission notice shall be included in all
-- copies or substantial portions of the Software.
--
-- THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
-- IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
-- FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
-- AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
-- LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
-- OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
-- SOFTWARE.
--

create table systems
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    name       VARCHAR,
    basePath   VARCHAR,
    sysKey     VARCHAR,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table pattern_repositories
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    repoKey    VARCHAR,
    name       VARCHAR,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table patterns
(
    id                    INTEGER NOT NULL PRIMARY KEY Autoincrement,
    patternKey            VARCHAR,
    name                  VARCHAR,
    family                VARCHAR,
    pattern_repository_id INTEGER REFERENCES pattern_repositories (id),
    created_at            NUMERIC,
    updated_at            NUMERIC
);

create table roles
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    roleKey    VARCHAR,
    name       VARCHAR,
    type       INTEGER,
    mandatory  BOOLEAN,
    pattern_id INTEGER REFERENCES patterns (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table roles_role_bindings
(
    id              INTEGER NOT NULL PRIMARY KEY Autoincrement,
    role_id         INTEGER REFERENCES roles (id),
    role_binding_id INTEGER REFERENCES role_bindings (id),
    created_at      NUMERIC,
    updated_at      NUMERIC
);

create table relations
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    relKey       VARCHAR,
    project_id   INTEGER,
    reference_id INTEGER,
    to_id        INTEGER,
    from_id      INTEGER,
    type         INTEGER,
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table pattern_chains
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    chainKey   VARCHAR,
    system_id  INTEGER REFERENCES systems (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table pattern_instances
(
    id               INTEGER NOT NULL PRIMARY KEY Autoincrement,
    instKey          VARCHAR,
    pattern_size     INTEGER,
    pattern_chain_id INTEGER REFERENCES pattern_chains (id),
    project_id       INTEGER REFERENCES projects (id),
    pattern_id       INTEGER REFERENCES patterns (id),
    created_at       NUMERIC,
    updated_at       NUMERIC
);

create table role_bindings
(
    id                  INTEGER NOT NULL PRIMARY KEY Autoincrement,
    pattern_instance_id INTEGER REFERENCES pattern_instances (id),
    created_at          NUMERIC,
    updated_at          NUMERIC
);

create table refs
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    refKey      VARCHAR,
    type        INTEGER,
    parent_id   INTEGER,
    parent_type VARCHAR,
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table findings
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    findingKey   VARCHAR,
    injected     NUMERIC,
    start        INTEGER,
    end          INTEGER,
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table projects_findings
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    project_id INTEGER REFERENCES projects (id),
    finding_id INTEGER REFERENCES findings (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table rules_findings
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    rule_id    INTEGER REFERENCES rules (id),
    finding_id INTEGER REFERENCES findings (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table finding_data
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    finding_id INTEGER,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table finding_data_points
(
    id              INTEGER NOT NULL PRIMARY KEY Autoincrement,
    finding_data_id INTEGER,
    handle          VARCHAR,
    value           DOUBLE,
    create_at       NUMERIC,
    update_at       NUMERIC
);

create table rules
(
    id                 INTEGER NOT NULL PRIMARY KEY Autoincrement,
    ruleKey            VARCHAR,
    name               VARCHAR,
    description        VARCHAR,
    priority           INTEGER,
    rule_repository_id INTEGER REFERENCES rule_repositories (id),
    created_at         NUMERIC,
    updated_at         NUMERIC
);

create table rules_tags
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    rule_id    INTEGER REFERENCES rules (id),
    tag_id     INTEGER REFERENCES tags (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table tags
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    tag        VARCHAR,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table rule_repositories
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    repoKey    VARCHAR,
    name       VARCHAR,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    measureKey VARCHAR,
    metricKey  VARCHAR,
    value      DOUBLE,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table metrics_measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    metric_id  INTEGER REFERENCES metrics (id),
    measure_id INTEGER REFERENCES measures (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table projects_measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    project_id INTEGER REFERENCES projects (id),
    measure_id INTEGER REFERENCES measures (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table namespaces_measures
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    namespace_id INTEGER REFERENCES namespaces (id),
    measure_id   INTEGER REFERENCES measures (id),
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table systems_measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    system_id  INTEGER REFERENCES systems (id),
    measure_id INTEGER REFERENCES measures (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table patterns_measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    pattern_id INTEGER REFERENCES patterns (id),
    measure_id INTEGER REFERENCES measures (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table files_measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    file_id    INTEGER REFERENCES files (id),
    measure_id INTEGER REFERENCES measures (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table modules_measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    module_id  INTEGER REFERENCES projects (id),
    measure_id INTEGER REFERENCES measures (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table initializers_measures
(
    id             INTEGER NOT NULL PRIMARY KEY Autoincrement,
    initializer_id INTEGER REFERENCES initializers (id),
    measure_id     INTEGER REFERENCES measures (id),
    created_at     NUMERIC,
    updated_at     NUMERIC
);

create table methods_measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    method_id  INTEGER REFERENCES methods (id),
    measure_id INTEGER REFERENCES measures (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table classes_measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    class_id   INTEGER REFERENCES classes (id),
    measure_id INTEGER REFERENCES measures (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table enums_measures
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    enum_id    INTEGER REFERENCES enums (id),
    measure_id INTEGER REFERENCES measures (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table interfaces_measures
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    interface_id INTEGER REFERENCES interfaces (id),
    measure_id   INTEGER REFERENCES measures (id),
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table constructors_measures
(
    id             INTEGER NOT NULL PRIMARY KEY Autoincrement,
    constructor_id INTEGER REFERENCES constructors (id),
    measure_id     INTEGER REFERENCES measures (id),
    created_at     NUMERIC,
    updated_at     NUMERIC
);

create table destructors_measures
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    destructor_id INTEGER REFERENCES destructors (id),
    measure_id    INTEGER REFERENCES measures (id),
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table metrics
(
    id                   INTEGER NOT NULL PRIMARY KEY Autoincrement,
    metricKey            VARCHAR,
    name                 VARCHAR,
    description          VARCHAR,
    handle               VARCHAR,
    evaluator            VARCHAR,
    metric_repository_id INTEGER REFERENCES metric_repositories (id),
    created_at           NUMERIC,
    updated_at           NUMERIC
);

create table metric_repositories
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    repoKey    VARCHAR,
    name       VARCHAR,
    toolName   VARCHAR,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table projects
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    projKey    VARCHAR,
    name       VARCHAR,
    version    VARCHAR,
    relPath    VARCHAR,
    srcPath    VARCHAR,
    binPath    VARCHAR,
    testPath   VARCHAR,
    system_id  INTEGER REFERENCES systems (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table languages
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    name       VARCHAR,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table projects_languages
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    project_id  INTEGER REFERENCES projects (id),
    language_id INTEGER REFERENCES languages (id),
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table modules
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    moduleKey  VARCHAR,
    name       VARCHAR,
    relPath    VARCHAR,
    project_id INTEGER REFERENCES projects (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table scms
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    scmKey     VARCHAR,
    name       VARCHAR,
    tag        VARCHAR,
    branch     VARCHAR,
    url        VARCHAR,
    project_id INTEGER REFERENCES projects (id),
    type       INTEGER,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table namespaces
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    nsKey         VARCHAR,
    name          VARCHAR,
    project_id    INTEGER REFERENCES projects (id),
    relPath       VARCHAR,
    parent_ns_id  INTEGER,
    parent_mod_id INTEGER,
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table files
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    fileKey      VARCHAR,
    pathIndex    INTEGER NOT NULL,
    name         VARCHAR,
    type         INTEGER,
    relPath      VARCHAR,
    start        INTEGER,
    end          INTEGER,
    parseStage   INTEGER,
    project_id   INTEGER REFERENCES projects (id),
    parent_ns_id INTEGER,
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table imports
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    name       VARCHAR,
    start      INTEGER,
    end        INTEGER,
    file_id    INTEGER REFERENCES files (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table unknown_types
(
    id               INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start            INTEGER,
    end              INTEGER,
    compKey          VARCHAR,
    name             VARCHAR,
    accessibility    INTEGER,
    qualified_name   VARCHAR,
    project_id       INTEGER REFERENCES projects (id),
    created_at       NUMERIC,
    updated_at       NUMERIC
);

create table classes
(
    id               INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start            INTEGER,
    end              INTEGER,
    compKey          VARCHAR,
    name             VARCHAR,
    abstract         INTEGER,
    accessibility    INTEGER,
    qualified_name    VARCHAR,
    namespace_id     INTEGER REFERENCES namespaces (id),
    parent_type_id   INTEGER,
    parent_type_type VARCHAR,
    parent_file_id   INTEGER,
    created_at       NUMERIC,
    updated_at       NUMERIC
);

create table enums
(
    id               INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start            INTEGER,
    end              INTEGER,
    compKey          VARCHAR,
    name             VARCHAR,
    accessibility    INTEGER,
    qualified_name   VARCHAR,
    namespace_id     INTEGER REFERENCES namespaces (id),
    parent_type_id   INTEGER,
    parent_type_type VARCHAR,
    parent_file_id   INTEGER,
    created_at       NUMERIC,
    updated_at       NUMERIC
);

create table interfaces
(
    id               INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start            INTEGER,
    end              INTEGER,
    compKey          VARCHAR,
    name             VARCHAR,
    accessibility    INTEGER,
    qualified_name   VARCHAR,
    namespace_id     INTEGER REFERENCES namespaces (id),
    parent_type_id   INTEGER,
    parent_type_type VARCHAR,
    parent_file_id   INTEGER,
    created_at       NUMERIC,
    updated_at       NUMERIC
);

create table literals
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start         INTEGER,
    end           INTEGER,
    compKey       VARCHAR,
    name          VARCHAR,
    accessibility INTEGER,
    parent_id     INTEGER,
    parent_type   VARCHAR,
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table initializers
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start         INTEGER,
    end           INTEGER,
    compKey       VARCHAR,
    name          VARCHAR,
    localVars     INTEGER,
    cfg           VARCHAR,
    accessibility INTEGER,
    parent_id     INTEGER,
    parent_type   VARCHAR,
    number        INTEGER,
    instance      INTEGER(1), -- boolean
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table fields
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start         INTEGER,
    end           INTEGER,
    compKey       VARCHAR,
    name          VARCHAR,
    accessibility INTEGER,
    parent_id     INTEGER,
    parent_type   VARCHAR,
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table methods
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start         INTEGER,
    end           INTEGER,
    compKey       VARCHAR,
    name          VARCHAR,
    localVars     INTEGER,
    accessibility INTEGER,
    cfg           VARCHAR,
    parent_id     INTEGER,
    parent_type   VARCHAR,
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table constructors
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start         INTEGER,
    end           INTEGER,
    compKey       VARCHAR,
    name          VARCHAR,
    localVars     INTEGER,
    cfg           VARCHAR,
    accessibility INTEGER,
    parent_id     INTEGER,
    parent_type   VARCHAR,
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table destructors
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    start         INTEGER,
    end           INTEGER,
    compKey       VARCHAR,
    name          VARCHAR,
    localVars     INTEGER,
    cfg           VARCHAR,
    accessibility INTEGER,
    parent_id     INTEGER,
    parent_type   VARCHAR,
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table parameters
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    name        VARCHAR,
    varg        INTEGER,
    parent_id   INTEGER,
    parent_type VARCHAR,
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table method_exceptions
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    parent_id   INTEGER,
    parent_type VARCHAR,
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table methods_method_exceptions
(
    id                  INTEGER NOT NULL PRIMARY KEY Autoincrement,
    method_id           INTEGER REFERENCES methods (id),
    method_exception_id INTEGER REFERENCES method_exceptions (id),
    created_at          NUMERIC,
    updated_at          NUMERIC
);

create table constructors_method_exceptions
(
    id                  INTEGER NOT NULL PRIMARY KEY Autoincrement,
    constructor_id      INTEGER REFERENCES constructors (id),
    method_exception_id INTEGER REFERENCES method_exceptions (id),
    created_at          NUMERIC,
    updated_at          NUMERIC
);

create table destructors_method_exceptions
(
    id                  INTEGER NOT NULL PRIMARY KEY Autoincrement,
    destructor_id       INTEGER REFERENCES destructors (id),
    method_exception_id INTEGER REFERENCES method_exceptions (id),
    created_at          NUMERIC,
    updated_at          NUMERIC
);

create table type_refs
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    dimensions   VARCHAR,
    typeName     VARCHAR,
    typeFullName VARCHAR,
    type         INTEGER,
    typeref_id   INTEGER REFERENCES type_refs (id),
    is_bound     INTEGER(1),
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table parameters_typerefs
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    parameter_id INTEGER REFERENCES parameters (id),
    type_ref_id  INTEGER REFERENCES type_refs (id),
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table methods_typerefs
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    method_id   INTEGER REFERENCES methods (id),
    type_ref_id INTEGER REFERENCES type_refs (id),
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table constructors_typerefs
(
    id             INTEGER NOT NULL PRIMARY KEY Autoincrement,
    constructor_id INTEGER REFERENCES constructors (id),
    type_ref_id    INTEGER REFERENCES type_refs (id),
    created_at     NUMERIC,
    updated_at     NUMERIC
);

create table destructors_typerefs
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    destructor_id INTEGER REFERENCES destructors (id),
    type_ref_id   INTEGER REFERENCES type_refs (id),
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table fields_typerefs
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    field_id    INTEGER REFERENCES fields (id),
    type_ref_id INTEGER REFERENCES type_refs (id),
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table methodexceptions_typerefs
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    exception_id INTEGER REFERENCES method_exceptions (id),
    type_ref_id  INTEGER REFERENCES type_refs (id),
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table typerefs_typerefs
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    parent_id  INTEGER REFERENCES parameters (id),
    child_id   INTEGER REFERENCES type_refs (id),
    created_at NUMERIC,
    updated_at NUMERIC
);

create table modifiers
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    name       VARCHAR,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table classes_modifiers
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    class_id    INTEGER REFERENCES classes (id),
    modifier_id INTEGER REFERENCES modifiers (id),
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table enums_modifiers
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    enum_id     INTEGER REFERENCES enums (id),
    modifier_id INTEGER REFERENCES modifiers (id),
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table interfaces_modifiers
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    interface_id INTEGER REFERENCES interfaces (id),
    modifier_id  INTEGER REFERENCES modifiers (id),
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table literals_modifiers
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    literal_id  INTEGER REFERENCES literals (id),
    modifier_id INTEGER REFERENCES modifiers (id),
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table initializers_modifiers
(
    id             INTEGER NOT NULL PRIMARY KEY Autoincrement,
    initializer_id INTEGER REFERENCES initializers (id),
    modifier_id    INTEGER REFERENCES modifiers (id),
    created_at     NUMERIC,
    updated_at     NUMERIC
);

create table fields_modifiers
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    field_id    INTEGER REFERENCES fields (id),
    modifier_id INTEGER REFERENCES modifiers (id),
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table methods_modifiers
(
    id          INTEGER NOT NULL PRIMARY KEY Autoincrement,
    method_id   INTEGER REFERENCES methods (id),
    modifier_id INTEGER REFERENCES modifiers (id),
    created_at  NUMERIC,
    updated_at  NUMERIC
);

create table constructors_modifiers
(
    id             INTEGER NOT NULL PRIMARY KEY Autoincrement,
    constructor_id INTEGER REFERENCES constructors (id),
    modifier_id    INTEGER REFERENCES modifiers (id),
    created_at     NUMERIC,
    updated_at     NUMERIC
);

create table destructors_modifiers
(
    id            INTEGER NOT NULL PRIMARY KEY Autoincrement,
    destructor_id INTEGER REFERENCES destructors (id),
    modifier_id   INTEGER REFERENCES modifiers (id),
    created_at    NUMERIC,
    updated_at    NUMERIC
);

create table parameters_modifiers
(
    id           INTEGER NOT NULL PRIMARY KEY Autoincrement,
    parameter_id INTEGER REFERENCES parameters (id),
    modifier_id  INTEGER REFERENCES modifiers (id),
    created_at   NUMERIC,
    updated_at   NUMERIC
);

create table template_params
(
    id         INTEGER NOT NULL PRIMARY KEY Autoincrement,
    name       VARCHAR,
    created_at NUMERIC,
    updated_at NUMERIC
);

create table template_params_typerefs
(
    id                INTEGER NOT NULL PRIMARY KEY Autoincrement,
    template_param_id INTEGER REFERENCES template_params (id),
    typeref_id        INTEGER REFERENCES type_refs (id),
    created_at        NUMERIC,
    updated_at        NUMERIC
);

create table methods_template_params
(
    id                INTEGER NOT NULL PRIMARY KEY Autoincrement,
    method_id         INTEGER REFERENCES methods (id),
    template_param_id INTEGER REFERENCES template_params (id),
    created_at        NUMERIC,
    updated_at        NUMERIC
);

create table constructors_template_params
(
    id                INTEGER NOT NULL PRIMARY KEY Autoincrement,
    constructor_id    INTEGER REFERENCES constructors (id),
    template_param_id INTEGER REFERENCES template_params (id),
    created_at        NUMERIC,
    updated_at        NUMERIC
);

create table destructors_template_params
(
    id                INTEGER NOT NULL PRIMARY KEY Autoincrement,
    destructor_id     INTEGER REFERENCES destructors (id),
    template_param_id INTEGER REFERENCES template_params (id),
    created_at        NUMERIC,
    updated_at        NUMERIC
);

create table fields_template_params
(
    id                INTEGER NOT NULL PRIMARY KEY Autoincrement,
    field_id          INTEGER REFERENCES fields (id),
    template_param_id INTEGER REFERENCES template_params (id),
    created_at        NUMERIC,
    updated_at        NUMERIC
);

create table interfaces_template_params
(
    id                INTEGER NOT NULL PRIMARY KEY Autoincrement,
    interface_id      INTEGER REFERENCES interfaces (id),
    template_param_id INTEGER REFERENCES template_params (id),
    created_at        NUMERIC,
    updated_at        NUMERIC
);

create table classes_template_params
(
    id                INTEGER NOT NULL PRIMARY KEY Autoincrement,
    class_id          INTEGER REFERENCES classes (id),
    template_param_id INTEGER REFERENCES template_params (id),
    created_at        NUMERIC,
    updated_at        NUMERIC
);

create table enums_template_params
(
    id                INTEGER NOT NULL PRIMARY KEY Autoincrement,
    enum_id           INTEGER REFERENCES enums (id),
    template_param_id INTEGER REFERENCES template_params (id),
    created_at        NUMERIC,
    updated_at        NUMERIC
);

insert into modifiers (name)
values ('STATIC'),
       ('FINAL'),
       ('ABSTRACT'),
       ('NATIVE'),
       ('STRICTFP'),
       ('SYNCHRONIZED'),
       ('TRANSIENT'),
       ('VOLATILE'),
       ('DEFAULT'),
       ('ASYNC'),
       ('CONST'),
       ('EXTERN'),
       ('READONLY'),
       ('SEALED'),
       ('UNSAFE'),
       ('VIRTUAL'),
       ('OUT'),
       ('REF'),
       ('PARAMS'),
       ('OVERRIDE'),
       ('NEW'),
       ('PARTIAL'),
       ('EXPLICIT'),
       ('IMPLICIT'),
       ('YIELD'),
       ('THIS');

insert into pattern_repositories (repoKey, name)
values ('gof', 'gof');

insert into patterns (patternKey, name, pattern_repository_id)
values ('gof:Abstract Factory', 'Abstract Factory', 1),
       ('gof:Builder', 'Builder', 1),
       ('gof:Factory Method', 'Factory Method', 1),
       ('gof:Prototype', 'Prototype', 1),
       ('gof:Singleton', 'Singleton', 1),
       ('gof:Adapter', 'Adapter', 1),
       ('gof:Bridge', 'Bridge', 1),
       ('gof:Composite', 'Composite', 1),
       ('gof:Decorator', 'Decorator', 1),
       ('gof:Facade', 'Facade', 1),
       ('gof:Flyweight', 'Flyweight', 1),
       ('gof:Proxy', 'Proxy', 1),
       ('gof:Proxy2', 'Proxy2', 1),
       ('gof:Chain of Responsibility', 'Chain of Responsibility', 1),
       ('gof:Command', 'Command', 1),
       ('gof:Interpreter', 'Interpreter', 1),
       ('gof:Iterator', 'Iterator', 1),
       ('gof:Mediator', 'Mediator', 1),
       ('gof:Memento', 'Memento', 1),
       ('gof:Observer', 'Observer', 1),
       ('gof:State', 'State', 1),
       ('gof:Strategy', 'Strategy', 1),
       ('gof:Template Method', 'Template Method', 1),
       ('gof:Visitor', 'Visitor', 1);