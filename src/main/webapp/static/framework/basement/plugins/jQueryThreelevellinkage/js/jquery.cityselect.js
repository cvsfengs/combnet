! function(a) {
    a.fn.citySelect = function(b) {
        function c(b) {
            var c, d = a(b),
                e = "active",
                f = a("ul", d);
            d.click(function() {
                a(this).toggleClass(e), f.stop(!0, !0).slideToggle()
            }), c = function() {
                d.removeClass(e), f.stop(!0, !0).slideUp()
            }, a("body").click(function(d) {
                a(d.target).is(b + " *") || c()
            })
        }
        var d, e = {
                setId: ["#Province", "#City", "#Area"],
                stval: ["请选择省份", "请选择城市", "请选择地区"],
                czemt: "i",
                inpvt: 'input[name^="cho"]',
                intva: !0
            },
            f = a.extend(e, b),
            g = f.setId,
            h = f.stval,
            i = f.czemt,
            j = f.inpvt,
            k = g.length;
        if (a.fn.removelist = function(b) {
            var c = {
                    removeAll: !1,
                    thisindex: 0
                },
                d = a.extend(c, b),
                e = a(this),
                f = a("ul li", e),
                g = (a("ul li:first", e), a("ul li:gt(0)", e)),
                k = a(i, e),
                l = a(j, e);
            return d.removeAll ? f.remove() : g.remove(), k.text(h[d.thisindex]), l.val(h[d.thisindex]), this
        }, a.fn.appendlist = function(b) {
            var c, d = {
                    theindex: "0"
                },
                e = a.extend(d, b),
                f = a(this),
                g = a("ul", f),
                h = dsy.Items[e.theindex],
                i = "";
            if ("undefined" == typeof h) return !1;
            for (c = 0; c < h.length; c++) i += '<li><a href="javascript:void(0)" alt="' + h[c] + '">' + h[c] + "</a></li>";
            g.append(i), i = ""
        }, a.fn.liClick = function() {
            var b, c, d;
            a("li", g[0]), a("li", g[1]), a("li", g[2]), a("li", g[0]).live("click", function() {
                b = a("li", g[0]).index(this) - 1;
                var c = a("a", this).attr("alt"),
                    d = a(i, g[0]),
                    e = a(j, g[0]);
                return d.text(c), e.val(c), a(g[1]).removelist({
                    thisindex: 1
                }), a(g[1]).appendlist({
                    theindex: "0_" + b
                }), a(g[2]).removelist({
                    thisindex: 2
                }), b
            }), a("li", g[1]).live("click", function() {
                c = a("li", g[1]).index(this) - 1;
                var d = a("a", this).attr("alt"),
                    e = a(i, g[1]),
                    f = a(j, g[1]);
                return e.text(d), f.val(d), a(g[2]).removelist({
                    thisindex: 2
                }), a(g[2]).appendlist({
                    theindex: "0_" + b + "_" + c
                }), c
            }), a("li", g[2]).live("click", function() {
                d = a("li", g[2]).index(this);
                var b = a("a", this).attr("alt"),
                    c = a(i, g[2]),
                    e = a(j, g[2]);
                return c.text(b), e.val(b), d
            })
        }, f.intva)
            for (d = 0; k > d; d++) a(g[d]).removelist({
                thisindex: d
            }), c(g[d]);
        a(g[0]).appendlist({
            theindex: "0"
        }), a.fn.liClick()
    }
}(jQuery);