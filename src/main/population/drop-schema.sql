
    alter table `accounting_record` 
       drop 
       foreign key `FK41jm4vk7runvmg5tderffrele`;

    alter table `accounting_record` 
       drop 
       foreign key `FKk1pmfnppwk0kav7xloy8u71uq`;

    alter table `activity` 
       drop 
       foreign key `FK1ufotopeofii4jlefyk9c7os5`;

    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `application` 
       drop 
       foreign key `FKp6hc01e2bc6ly2q8rv4b7ubro`;

    alter table `application` 
       drop 
       foreign key `FKk5ibe41quxsif8im882xv4afo`;

    alter table `application` 
       drop 
       foreign key `FKl4fp0cd8c008ma79n6w58xhk9`;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `banner` 
       drop 
       foreign key `FKr19baq0bri0akndc7ruwhngy4`;

    alter table `bookkeeper` 
       drop 
       foreign key FK_krvjp9eaqyapewl2igugbo9o8;

    alter table `bookkeeper_request` 
       drop 
       foreign key `FKrkmyfaktfktoo2v26a9qu4ebb`;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `discussion_forum` 
       drop 
       foreign key `FKbfag2xg62p5csp5sfcf99thfd`;

    alter table `discussion_forum` 
       drop 
       foreign key `FKmcgrpw22g3baap51wq319v1bp`;

    alter table `entrepreneur` 
       drop 
       foreign key FK_r6tqltqvrlh1cyy8rsj5pev1q;

    alter table `investment_round` 
       drop 
       foreign key `FKkj1l8c2ftn9c65y061me6t37j`;

    alter table `investor` 
       drop 
       foreign key FK_dcek5rr514s3rww0yy57vvnpq;

    alter table `message` 
       drop 
       foreign key `FKd8wmf6nghttk2h9gq7v8p9lqo`;

    alter table `message` 
       drop 
       foreign key `FKr2om5f6tefk2fg0fyl53q2kgd`;

    alter table `participant` 
       drop 
       foreign key `FK80gruu22vbyiojed5sawtqc6a`;

    alter table `participant` 
       drop 
       foreign key `FK2rgdydjuquk8s9d5tqijli0hy`;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    drop table if exists `accounting_record`;

    drop table if exists `activity`;

    drop table if exists `administrator`;

    drop table if exists `anonymous`;

    drop table if exists `application`;

    drop table if exists `authenticated`;

    drop table if exists `banner`;

    drop table if exists `bookkeeper`;

    drop table if exists `bookkeeper_request`;

    drop table if exists `caceres_bulletin`;

    drop table if exists `challenge`;

    drop table if exists `consumer`;

    drop table if exists `credit_card`;

    drop table if exists `customisation_parameters`;

    drop table if exists `discussion_forum`;

    drop table if exists `entrepreneur`;

    drop table if exists `gonzalez_bulletin`;

    drop table if exists `inquirie`;

    drop table if exists `investment_round`;

    drop table if exists `investor`;

    drop table if exists `message`;

    drop table if exists `notice`;

    drop table if exists `overture`;

    drop table if exists `participant`;

    drop table if exists `provider`;

    drop table if exists `tech_record`;

    drop table if exists `tool_record`;

    drop table if exists `user_account`;

    drop table if exists `hibernate_sequence`;
