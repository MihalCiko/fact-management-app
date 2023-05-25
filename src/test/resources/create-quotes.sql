-- Inserting quotes
INSERT INTO quotes (id, author, author_slug, created_at, likes, quote, quote_length, updated_at) VALUES
('a6fbd9db-5b9b-4cd9-94c7-f58f7c4f1eb8','Vernon Cooper','vernon-cooper','2019-01-08',0,'These days people seek knowledge, not wisdom. Knowledge is of the past; wisdom is of the future.',96,'2023-04-14'),
('ddd4b4fb-9f59-4f30-96eb-e31c193c9fa8','Abraham Lincoln','abraham-lincoln','2022-03-12',0,'Sir, my concern is not whether God is on our side; my greatest concern is to be on Gods side, for God is always right.',119,'2023-04-14'),
('eb6301f4-e4a3-4e92-b667-e171ede7098e','Mahatma Gandhi','mahatma-gandhi','2019-12-13',0,'Forgiveness is choosing to love. It is the first skill of self-giving love.',75,'2023-04-14'),
('08efbd36-87ec-4b0a-9e30-adcab5bcc052','Max Planck','max-planck','2019-12-02',0,'It is not the possession of truth, but the success which attends the seeking after it, that enriches the seeker and brings happiness to him.',140,'2023-04-14'),
('e203b764-08ae-473a-8e38-91785197cd6d','Samuel Johnson','samuel-johnson','2020-12-19',0,'If a man does not make new acquaintances as he advances through life, he will soon find himself left alone. A man, sir, should keep his friendship in a constant repair.',168,'2023-04-14'),
('52fd09c5-9251-4f03-b66d-01a18b89dfc4','Jean Antoine Petit-Senn','jean-antoine-petit-senn','2021-01-20',0,'Not what we have but what we enjoy constitutes our abundance.',61,'2023-04-14'),
('478ca0f3-6c16-41f3-85d0-aeffeb00ea7e','Niels Bohr','niels-bohr','2019-02-13',0,'How wonderful that we have met with a paradox. Now we have some hope of making progress.',88,'2023-04-14'),
('5846352f-863c-4b18-8480-b6b69cc74ff1','Dale Earnhardt','dale-earnhardt','2021-01-10',0,'The winner aint the one with the fastest car its the one who refuses to lose.',79,'2023-04-14'),
('00728987-6b75-459d-8d1c-c9b02c440131','Eleanor Roosevelt','eleanor-roosevelt','2019-02-11',0,'People grow through experience if they meet life honestly and courageously. This is how character is built.',107,'2023-04-14'),
('8614be0a-d6d2-4d21-8188-51429f26571d','Emily Dickinson','emily-dickinson','2019-11-26',0,'My friends are my estate.',25,'2023-04-14');

-- Inserting quotes_tags
INSERT INTO tags (id, created_at, name, updated_at) VALUES
('3f9d4dc7-73ed-40f0-9c9d-47fc0528d318','2023-05-19 14:51:11.471242','History','2023-05-19 14:51:11.471242'),
('3f9d4dc7-73ed-40f0-9c9d-47fc0528d310','2023-05-19 14:51:12.548207','Science','2023-05-19 14:51:12.548207'),
('73227fca-8514-4b8c-8fe1-9f36c8fb18d5','2023-05-19 14:51:11.312231','Wisdom','2023-05-19 14:51:11.312231'),
('21f4a537-4105-4fd8-a216-0bd7c7c67c38','2023-05-19 14:51:11.788914','Character','2023-05-19 14:51:11.788914'),
('508cf26b-c4f4-4be8-8c83-5c5579a9b0bf','2023-05-19 14:51:11.631347','Success','2023-05-19 14:51:11.631347'),
('9fa27050-3a64-4145-88ba-2e2c7442805e','2023-05-19 14:51:11.939339','Famous Quotes','2023-05-19 14:51:11.939339'),
('9e5ad11d-772b-4777-8f7a-4cefacd571ff','2023-05-19 14:51:11.310201','Future','2023-05-19 14:51:11.310201'),
('021f45e4-dcbf-4fc4-a7bd-6f3957696271','2023-05-19 14:51:12.240827','Friendship','2023-05-19 14:51:12.241336'),
('60ce325f-374b-4882-ad44-1b84d174f8ca','2023-05-19 14:51:11.473272','Spirituality','2023-05-19 14:51:11.473272');

-- Inserting tags
INSERT INTO quotes_tags (quote_id, tags_id) VALUES
('ddd4b4fb-9f59-4f30-96eb-e31c193c9fa8','3f9d4dc7-73ed-40f0-9c9d-47fc0528d310'),
('478ca0f3-6c16-41f3-85d0-aeffeb00ea7e','3f9d4dc7-73ed-40f0-9c9d-47fc0528d310'),
('a6fbd9db-5b9b-4cd9-94c7-f58f7c4f1eb8','73227fca-8514-4b8c-8fe1-9f36c8fb18d5'),
('eb6301f4-e4a3-4e92-b667-e171ede7098e','73227fca-8514-4b8c-8fe1-9f36c8fb18d5'),
('00728987-6b75-459d-8d1c-c9b02c440131','21f4a537-4105-4fd8-a216-0bd7c7c67c38'),
('08efbd36-87ec-4b0a-9e30-adcab5bcc052','508cf26b-c4f4-4be8-8c83-5c5579a9b0bf'),
('52fd09c5-9251-4f03-b66d-01a18b89dfc4','9fa27050-3a64-4145-88ba-2e2c7442805e'),
('478ca0f3-6c16-41f3-85d0-aeffeb00ea7e','9fa27050-3a64-4145-88ba-2e2c7442805e'),
('5846352f-863c-4b18-8480-b6b69cc74ff1','9fa27050-3a64-4145-88ba-2e2c7442805e'),
('a6fbd9db-5b9b-4cd9-94c7-f58f7c4f1eb8','021f45e4-dcbf-4fc4-a7bd-6f3957696271'),
('e203b764-08ae-473a-8e38-91785197cd6d','021f45e4-dcbf-4fc4-a7bd-6f3957696271'),
('8614be0a-d6d2-4d21-8188-51429f26571d','021f45e4-dcbf-4fc4-a7bd-6f3957696271'),
('ddd4b4fb-9f59-4f30-96eb-e31c193c9fa8','021f45e4-dcbf-4fc4-a7bd-6f3957696271');


