insert into exercice (id, name, description, difficuly) values (1, 'Développé couché', '', '');
insert into exercice (id, name, description, difficuly) values (2, 'Pompes', '', '');
insert into exercice (id, name, description, difficuly) values (3, 'Développé incliné', '', '');
insert into exercice (id, name, description, difficuly) values (4, 'Soulevé de terre', '', '');

insert into muscle (id, body_part, image, name) values (1, '', '', 'Triceps');
insert into muscle (id, body_part, image, name) values (2, '', '', 'Biceps');
insert into muscle (id, body_part, image, name) values (3, '', '', 'Pectoraux');

insert into relation_exercice_muscle (exercice_id, muscle_id, pourcentage_participation) values (1, 3, .2);
insert into relation_exercice_muscle (exercice_id, muscle_id, pourcentage_participation) values (1, 1, .8);
insert into relation_exercice_muscle (exercice_id, muscle_id, pourcentage_participation) values (2, 3, .2);
insert into relation_exercice_muscle (exercice_id, muscle_id, pourcentage_participation) values (2, 1, .8);
insert into relation_exercice_muscle (exercice_id, muscle_id, pourcentage_participation) values (4, 2, .1);