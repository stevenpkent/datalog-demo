(ns stevenpkent.datalog-demo
  (:gen-class)
  (:require [crux.api :as crux]))

(def node (crux/start-node {}))

(comment                                                    ;; tutorial 1
  (def my-docs
    [{:person/name "James Cameron",
      :person/born #inst "1954-08-16T00:00:00.000-00:00",
      :crux.db/id -100}
     {:person/name "Arnold Schwarzenegger",
      :person/born #inst "1947-07-30T00:00:00.000-00:00",
      :crux.db/id -101}
     {:person/name "Linda Hamilton",
      :person/born #inst "1956-09-26T00:00:00.000-00:00",
      :crux.db/id -102}
     {:person/name "Michael Biehn",
      :person/born #inst "1956-07-31T00:00:00.000-00:00",
      :crux.db/id -103}
     {:person/name "Ted Kotcheff",
      :person/born #inst "1931-04-07T00:00:00.000-00:00",
      :crux.db/id -104}
     {:person/name "Sylvester Stallone",
      :person/born #inst "1946-07-06T00:00:00.000-00:00",
      :crux.db/id -105}
     {:person/name "Richard Crenna",
      :person/born #inst "1926-11-30T00:00:00.000-00:00",
      :person/death #inst "2003-01-17T00:00:00.000-00:00",
      :crux.db/id -106}
     {:person/name "Brian Dennehy",
      :person/born #inst "1938-07-09T00:00:00.000-00:00",
      :crux.db/id -107}
     {:person/name "John McTiernan",
      :person/born #inst "1951-01-08T00:00:00.000-00:00",
      :crux.db/id -108}
     {:person/name "Elpidia Carrillo",
      :person/born #inst "1961-08-16T00:00:00.000-00:00",
      :crux.db/id -109}
     {:person/name "Carl Weathers",
      :person/born #inst "1948-01-14T00:00:00.000-00:00",
      :crux.db/id -110}
     {:person/name "Richard Donner",
      :person/born #inst "1930-04-24T00:00:00.000-00:00",
      :crux.db/id -111}
     {:person/name "Mel Gibson",
      :person/born #inst "1956-01-03T00:00:00.000-00:00",
      :crux.db/id -112}
     {:person/name "Danny Glover",
      :person/born #inst "1946-07-22T00:00:00.000-00:00",
      :crux.db/id -113}
     {:person/name "Gary Busey",
      :person/born #inst "1944-07-29T00:00:00.000-00:00",
      :crux.db/id -114}
     {:person/name "Paul Verhoeven",
      :person/born #inst "1938-07-18T00:00:00.000-00:00",
      :crux.db/id -115}
     {:person/name "Peter Weller",
      :person/born #inst "1947-06-24T00:00:00.000-00:00",
      :crux.db/id -116}
     {:person/name "Nancy Allen",
      :person/born #inst "1950-06-24T00:00:00.000-00:00",
      :crux.db/id -117}
     {:person/name "Ronny Cox",
      :person/born #inst "1938-07-23T00:00:00.000-00:00",
      :crux.db/id -118}
     {:person/name "Mark L. Lester",
      :person/born #inst "1946-11-26T00:00:00.000-00:00",
      :crux.db/id -119}
     {:person/name "Rae Dawn Chong",
      :person/born #inst "1961-02-28T00:00:00.000-00:00",
      :crux.db/id -120}
     {:person/name "Alyssa Milano",
      :person/born #inst "1972-12-19T00:00:00.000-00:00",
      :crux.db/id -121}
     {:person/name "Bruce Willis",
      :person/born #inst "1955-03-19T00:00:00.000-00:00",
      :crux.db/id -122}
     {:person/name "Alan Rickman",
      :person/born #inst "1946-02-21T00:00:00.000-00:00",
      :crux.db/id -123}
     {:person/name "Alexander Godunov",
      :person/born #inst "1949-11-28T00:00:00.000-00:00",
      :person/death #inst "1995-05-18T00:00:00.000-00:00",
      :crux.db/id -124}
     {:person/name "Robert Patrick",
      :person/born #inst "1958-11-05T00:00:00.000-00:00",
      :crux.db/id -125}
     {:person/name "Edward Furlong",
      :person/born #inst "1977-08-02T00:00:00.000-00:00",
      :crux.db/id -126}
     {:person/name "Jonathan Mostow",
      :person/born #inst "1961-11-28T00:00:00.000-00:00",
      :crux.db/id -127}
     {:person/name "Nick Stahl",
      :person/born #inst "1979-12-05T00:00:00.000-00:00",
      :crux.db/id -128}
     {:person/name "Claire Danes",
      :person/born #inst "1979-04-12T00:00:00.000-00:00",
      :crux.db/id -129}
     {:person/name "George P. Cosmatos",
      :person/born #inst "1941-01-04T00:00:00.000-00:00",
      :person/death #inst "2005-04-19T00:00:00.000-00:00",
      :crux.db/id -130}
     {:person/name "Charles Napier",
      :person/born #inst "1936-04-12T00:00:00.000-00:00",
      :person/death #inst "2011-10-05T00:00:00.000-00:00",
      :crux.db/id -131}
     {:person/name "Peter MacDonald", :crux.db/id -132}
     {:person/name "Marc de Jonge",
      :person/born #inst "1949-02-16T00:00:00.000-00:00",
      :person/death #inst "1996-06-06T00:00:00.000-00:00",
      :crux.db/id -133}
     {:person/name "Stephen Hopkins", :crux.db/id -134}
     {:person/name "Ruben Blades",
      :person/born #inst "1948-07-16T00:00:00.000-00:00",
      :crux.db/id -135}
     {:person/name "Joe Pesci",
      :person/born #inst "1943-02-09T00:00:00.000-00:00",
      :crux.db/id -136}
     {:person/name "Ridley Scott",
      :person/born #inst "1937-11-30T00:00:00.000-00:00",
      :crux.db/id -137}
     {:person/name "Tom Skerritt",
      :person/born #inst "1933-08-25T00:00:00.000-00:00",
      :crux.db/id -138}
     {:person/name "Sigourney Weaver",
      :person/born #inst "1949-10-08T00:00:00.000-00:00",
      :crux.db/id -139}
     {:person/name "Veronica Cartwright",
      :person/born #inst "1949-04-20T00:00:00.000-00:00",
      :crux.db/id -140}
     {:person/name "Carrie Henn", :crux.db/id -141}
     {:person/name "George Miller",
      :person/born #inst "1945-03-03T00:00:00.000-00:00",
      :crux.db/id -142}
     {:person/name "Steve Bisley",
      :person/born #inst "1951-12-26T00:00:00.000-00:00",
      :crux.db/id -143}
     {:person/name "Joanne Samuel", :crux.db/id -144}
     {:person/name "Michael Preston",
      :person/born #inst "1938-05-14T00:00:00.000-00:00",
      :crux.db/id -145}
     {:person/name "Bruce Spence",
      :person/born #inst "1945-09-17T00:00:00.000-00:00",
      :crux.db/id -146}
     {:person/name "George Ogilvie",
      :person/born #inst "1931-03-05T00:00:00.000-00:00",
      :crux.db/id -147}
     {:person/name "Tina Turner",
      :person/born #inst "1939-11-26T00:00:00.000-00:00",
      :crux.db/id -148}
     {:person/name "Sophie Marceau",
      :person/born #inst "1966-11-17T00:00:00.000-00:00",
      :crux.db/id -149}

     {:movie/title "The Terminator",
      :movie/year 1984,
      :movie/director -100,
      :movie/cast [-101 -102 -103],
      :movie/sequel -207,
      :crux.db/id -200}
     {:movie/title "First Blood",
      :movie/year 1982,
      :movie/director -104,
      :movie/cast [-105 -106 -107],
      :movie/sequel -209,
      :crux.db/id -201}
     {:movie/title "Predator",
      :movie/year 1987,
      :movie/director -108,
      :movie/cast [-101 -109 -110],
      :movie/sequel -211,
      :crux.db/id -202}
     {:movie/title "Lethal Weapon",
      :movie/year 1987,
      :movie/director -111,
      :movie/cast [-112 -113 -114],
      :movie/sequel -212,
      :crux.db/id -203}
     {:movie/title "RoboCop",
      :movie/year 1987,
      :movie/director -115,
      :movie/cast [-116 -117 -118],
      :crux.db/id -204}
     {:movie/title "Commando",
      :movie/year 1985,
      :movie/director -119,
      :movie/cast [-101 -120 -121],
      :trivia
      "In 1986, a sequel was written with an eye to having\n  John McTiernan direct. Schwarzenegger wasn't interested in reprising\n  the role. The script was then reworked with a new central character,\n  eventually played by Bruce Willis, and became Die Hard",
      :crux.db/id -205}
     {:movie/title "Die Hard",
      :movie/year 1988,
      :movie/director -108,
      :movie/cast [-122 -123 -124],
      :crux.db/id -206}
     {:movie/title "Terminator 2: Judgment Day",
      :movie/year 1991,
      :movie/director -100,
      :movie/cast [-101 -102 -125 -126],
      :movie/sequel -208,
      :crux.db/id -207}
     {:movie/title "Terminator 3: Rise of the Machines",
      :movie/year 2003,
      :movie/director -127,
      :movie/cast [-101 -128 -129],
      :crux.db/id -208}
     {:movie/title "Rambo: First Blood Part II",
      :movie/year 1985,
      :movie/director -130,
      :movie/cast [-105 -106 -131],
      :movie/sequel -210,
      :crux.db/id -209}
     {:movie/title "Rambo III",
      :movie/year 1988,
      :movie/director -132,
      :movie/cast [-105 -106 -133],
      :crux.db/id -210}
     {:movie/title "Predator 2",
      :movie/year 1990,
      :movie/director -134,
      :movie/cast [-113 -114 -135],
      :crux.db/id -211}
     {:movie/title "Lethal Weapon 2",
      :movie/year 1989,
      :movie/director -111,
      :movie/cast [-112 -113 -136],
      :movie/sequel -213,
      :crux.db/id -212}
     {:movie/title "Lethal Weapon 3",
      :movie/year 1992,
      :movie/director -111,
      :movie/cast [-112 -113 -136],
      :crux.db/id -213}
     {:movie/title "Alien",
      :movie/year 1979,
      :movie/director -137,
      :movie/cast [-138 -139 -140],
      :movie/sequel -215,
      :crux.db/id -214}
     {:movie/title "Aliens",
      :movie/year 1986,
      :movie/director -100,
      :movie/cast [-139 -141 -103],
      :crux.db/id -215}
     {:movie/title "Mad Max",
      :movie/year 1979,
      :movie/director -142,
      :movie/cast [-112 -143 -144],
      :movie/sequel -217,
      :crux.db/id -216}
     {:movie/title "Mad Max 2",
      :movie/year 1981,
      :movie/director -142,
      :movie/cast [-112 -145 -146],
      :movie/sequel -218,
      :crux.db/id -217}
     {:movie/title "Mad Max Beyond Thunderdome",
      :movie/year 1985,
      :movie/director [-142 -147],
      :movie/cast [-112 -148],
      :crux.db/id -218}
     {:movie/title "Braveheart",
      :movie/year 1995,
      :movie/director [-112],
      :movie/cast [-112 -149],
      :crux.db/id -219}])

  ;; add data
  (crux/submit-tx node (for [doc my-docs] [:crux.tx/put doc]))
  (crux/sync node)

  ;; query movies
  (crux/q (crux/db node) {:find '[title]
                          :where '[[_ :movie/title title]]})

  ;; qyery for Ridley Scott
  (crux/q (crux/db node) {:find '[eid]
                          :where '[[eid :person/name "Ridley Scott"]]})

  ;; query where you want all eids where the datum has a :person/name attribute
  ;; the _ means "don't care what the actual value is"
  (crux/q (crux/db node) {:find  '[eid]
                          :where '[[eid :person/name _]]})

  ;; find eids of movies made in 1987
  (crux/q (crux/db node) {:find '[eid]
                          :where '[[eid :movie/year 1987]]})

  ;; find the eids and titles of movies
  (crux/q (crux/db node) {:find '[eid title]
                          :where '[[eid :movie/title title]]})

  ;; find the name of all people
  (crux/q (crux/db node) {:find '[name]
                          :where '[[_ :person/name name]]})

  ;; find titles for movies from 1987
  ;; notice multiple data patterns in the :where vector
  (crux/q (crux/db node) {:find '[title]
                          :where '[[eid :movie/year 1987]
                                   [eid :movie/title title]]})

  ;; who starred in Lethal Weapon?
  (crux/q (crux/db node) {:find '[name]
                          :where '[[movie :movie/title "Lethal Weapon"]
                                   [movie :movie/cast cast]
                                   [cast :person/name name]]})

  ;; find movie titles made in 1985
  (crux/q (crux/db node) {:find '[title]
                          :where '[[movies :movie/year 1985]
                                   [movies :movie/title title]]})

  ;; what year was Alien released?
  (crux/q (crux/db node) {:find '[year]
                          :where '[[movie :movie/title "Alien"]
                                   [movie :movie/year year]]})

  ;; who directed RoboCop?
  (crux/q (crux/db node) {:find '[director-name]
                          :where '[[movie :movie/title "RoboCop"]
                                   [movie :movie/director director]
                                   [director :person/name director-name]]})

  ;; which directors have directed Arnold Schwarzenegger in a movie?
  (crux/q (crux/db node) {:find '[name]
                          :where '[[p :person/name "Arnold Schwarzenegger"]
                                   [m :movie/cast p]
                                   [m :movie/director d]
                                   [d :person/name name]]})

  ;; MAKING A QUERY REUSABLE
  ;; which movies has Sylvester Stallone been in?
  (crux/q (crux/db node) {:find '[title]
                          :where '[[p :person/name "Sylvester Stallone"]
                                   [m :movie/cast p]
                                   [m :movie/title title]]})

  (defn movies-x-has-acted-in? [name]
    (crux/q (crux/db node) {:find  '[title]
                            :in    '[name]
                            :where '[[p :person/name name]
                                     [m :movie/cast p]
                                     [m :movie/title title]]}
            name)

    )

  (defn movies-with-director-actor-collaboration [director actor]
    (crux/q (crux/db node) {:find '[title]
                            :in '[director actor]
                            :where '[[d :person/name director]
                                     [a :person/name actor]
                                     [m :movie/director d]
                                     [m :movie/cast a]
                                     [m :movie/title title]]}
            director actor))

  ;; https://nextjournal.com/try/learn-crux-datalog-today/learn-crux-datalog-today






  )

(defn greet
  "Callable entry point to the application."
  [data]
  (println (str "Hello, " (or (:name data) "World") "!")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))
