(ns job-streamer.notificator.template
  (:import [com.github.jknack.handlebars Handlebars]
           [com.github.jknack.handlebars.helper StringHelpers]))

(def handlebars (Handlebars.))
(.registerHelpers handlebars StringHelpers)

(defn render-inline [inline parameters]
  (let [template (.compileInline handlebars inline)]
    (.apply template parameters)))

(defn render [template-name parameters]
  (let [template (.compile handlebars template-name)]
    (.apply template parameters)))
